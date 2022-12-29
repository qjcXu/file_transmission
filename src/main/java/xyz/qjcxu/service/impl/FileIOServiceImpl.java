package xyz.qjcxu.service.impl;

import org.springframework.stereotype.Service;
import xyz.qjcxu.entity.Files;
import xyz.qjcxu.service.FileIOService;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @since 22.12.28 20:39
 */
@Service
public class FileIOServiceImpl implements FileIOService {
  @Override
  public List<Files> getAllFiles(String path) {
    List<Files> files = new ArrayList<>();
    File file = new File(path);
    if (!file.exists()) file.mkdir();
    Arrays.stream(Objects.requireNonNull(file.listFiles())).forEach(f -> {
      Files fileTmp = new Files();
      fileTmp.setName(f.getName());
      fileTmp.setPath(f.getAbsolutePath());
      if (f.isFile()) {
        fileTmp.setFile(true);
      }
      if (f.isDirectory()) {
        fileTmp.setFile(false);
      }
      files.add(fileTmp);
    });
    return files;
  }
}
