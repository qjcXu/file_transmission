package xyz.qjcxu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import xyz.qjcxu.common.Result;
import xyz.qjcxu.service.FileIOService;
import xyz.qjcxu.utils.StorageUtil;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * @since 22.12.29 14:16
 */
@RestController
public class LoadFileController {

  @Autowired
  private FileIOService fileIOService;

  @GetMapping("/getfile/{path}")
  public void getFile(@PathVariable String path, HttpServletResponse response) throws IOException {
    StorageUtil.loadFile(path, response);
  }

  @GetMapping("/getfiles/{path}")
  public Result getFiles(@PathVariable String path, HttpServletResponse response) {
    path = path.replaceAll("&", "/");
    return Result.success().setCodeMsg(200, "ok").setData(fileIOService.getAllFiles(path));
  }
}
