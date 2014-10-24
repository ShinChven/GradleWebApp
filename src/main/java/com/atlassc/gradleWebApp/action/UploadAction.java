package com.atlassc.gradleWebApp.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.*;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * 文件上传的Action，此Action 中将接收一个byte[] 数据包，其中包括json 对象和图片文件。</p>
 * bytes[0-3] 为json 对象的byte 数组长度jsonBytesLength</p>
 * json对象的数据位于bytes[4] - bytes[jsonBytesLength]</p>
 * 图片数据位于json对象之后的所有数据bytes[1+bytes[0]] - bytes[bytes.length]</p>
 * Created by ShinChven on 2014/10/22.
 */
@Action(value = "file")
@ParentPackage("basePackage")
@Namespace("/")
@InterceptorRefs({
        @InterceptorRef(value = "fileUpload", params = {"allowedTypes", "binary/octet-stream"}),
        @InterceptorRef("basicStack")
})
public class UploadAction extends ActionSupport {
    @Override
    public String execute() throws Exception {

        ActionContext context = ActionContext.getContext();
        HttpServletRequest request = (HttpServletRequest) context
                .get(ServletActionContext.HTTP_REQUEST);
        ServletInputStream in = request.getInputStream();
        // 保存路径
//        String realPath = ServletActionContext.getServletContext().getRealPath(
//                "/");
        String realPath = "D:\\fileUpload.jpg";
        File file = new File(realPath);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        // 读取流
        byte[] b = new byte[1024 * 50]; //限制流的读取大小
        int len = 0;
        while ((len = in.read(b)) > 0) {
            System.out.println("writing: " + len);
            baos.write(b, 0, len);
        }

        // 拆解数据包，读取JSON
        byte[] bucket = baos.toByteArray();


//        byte jsonLengthByte = bucket[0];
//        byte[] jsonByte = new byte[jsonLengthByte];
//        System.arraycopy(bucket, 1, jsonByte, 0, jsonByte.length);
//        String json = new String(jsonByte, "UTF-8");
//        System.out.println(json);
//
//        int imageBytesLength = bucket.length - 1 - jsonByte.length;
//        byte[] imgBytes = new byte[imageBytesLength];
//        System.arraycopy(bucket, 1 + jsonLengthByte, imgBytes, 0, imageBytesLength);

        byte[] jsonLengthBytes = new byte[4];
        System.arraycopy(bucket, 0, jsonLengthBytes, 0, 4);
        String jsonLengthStr = new String(jsonLengthBytes);
        int jsonLength = Integer.parseInt(jsonLengthStr);
        System.out.println("jsonLength:" + jsonLength);

        byte[] jsonBytes = new byte[jsonLength];
        System.arraycopy(bucket, 4, jsonBytes, 0, jsonLength);
        String json = new String(jsonBytes, "UTF-8");
        System.out.println(json);

        int imageBytesLength = bucket.length - jsonLengthBytes.length - jsonBytes.length;
        byte[] imgBytes = new byte[imageBytesLength];
        int srcPos = jsonLengthBytes.length + jsonBytes.length;
        System.out.println("起点："+srcPos);
        System.out.println("image 大小："+imageBytesLength);
        System.out.println("数据包大小："+bucket.length);
        System.arraycopy(bucket, srcPos, imgBytes, 0, imageBytesLength);


        // 保存图片文件
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(imgBytes);
        fos.flush();
        fos.close();
        in.close();

        PrintWriter writer = ServletActionContext.getResponse().getWriter();
        writer.print(SUCCESS);
        writer.flush();
        System.out.println("result:" + file.exists());
        return null;
    }
}
