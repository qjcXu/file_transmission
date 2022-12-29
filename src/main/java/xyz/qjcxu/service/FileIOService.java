package xyz.qjcxu.service;

import xyz.qjcxu.entity.Files;

import java.util.List;

/**
 * @since 22.12.28 20:39
 */
public interface FileIOService {

  List<Files> getAllFiles(String path);
}
