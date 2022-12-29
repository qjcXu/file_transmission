package xyz.qjcxu.utils;

import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.UUID;

/**
 * @since 22.12.29 13:24
 */
public class StorageUtil {
  public static void storageFile(String path, MultipartFile multipartFile, HttpServletRequest request) {
    File folder = new File(path + "\\" + LocalDate.now());
    if (!folder.isDirectory()) {
      folder.mkdirs();
    }
    String oldName = multipartFile.getOriginalFilename();
    String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."), oldName.length());
    try {
      multipartFile.transferTo(new File(folder, newName));
      System.out.println(new File(folder, newName).getAbsolutePath());
      String filePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/update/" + LocalDate.now() + newName;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void loadFile(String path, HttpServletResponse response) throws IOException {
    path = path.replaceAll("&", "/");
    File file = new File(path);
    response.reset();
    response.setContentType("application/octet-stream");
    response.setCharacterEncoding("utf-8");
    response.setContentLength((int) file.length());
    response.setHeader("Content-Disposition", "attachment;filename=" + path.substring(path.lastIndexOf('/') + 1));

    try(BufferedInputStream bis = new BufferedInputStream(Files.newInputStream(file.toPath()));) {
      byte[] buff = new byte[1024];
      OutputStream os  = response.getOutputStream();
      int i = 0;
      while ((i = bis.read(buff)) != -1) {
        os.write(buff, 0, i);
        os.flush();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
