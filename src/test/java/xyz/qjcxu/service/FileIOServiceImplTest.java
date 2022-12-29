package xyz.qjcxu.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.UnknownHostException;

/**
 * @since 22.12.28 20:41
 */
@SpringBootTest
public class FileIOServiceImplTest {
  @Autowired
  FileIOService fileIOService;
  @Value("${share_dir}")
  private String path;
  @Test
  void getAllFiles() throws UnknownHostException {
    fileIOService.getAllFiles(path);
  }
}
