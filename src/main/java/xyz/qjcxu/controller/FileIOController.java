package xyz.qjcxu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import xyz.qjcxu.common.Result;
import xyz.qjcxu.service.FileIOService;
import xyz.qjcxu.utils.StorageUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * @since 22.12.28 20:21
 */
@RestController
@RequestMapping("/file")
public class FileIOController {
  @Value("${share_dir}")
  private String path;
  @Autowired
  private FileIOService fileIOService;

  @GetMapping
  public Result getFilePath() {
    return Result.success().setCodeMsg(200, "ok").setData(fileIOService.getAllFiles(path));
  }

  @PostMapping
  public void storageFile(@RequestParam("files") MultipartFile multipartFile, HttpServletRequest request) {
    StorageUtil.storageFile(path, multipartFile, request);
  }
}
