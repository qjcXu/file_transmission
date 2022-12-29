package xyz.qjcxu.entity;

/**
 * @since 22.12.28 21:02
 */
public class Files {

  private String name;

  private String path;

  private Boolean isFile;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public Boolean getFile() {
    return isFile;
  }

  public void setFile(Boolean file) {
    isFile = file;
  }

  @Override
  public String toString() {
    return "Files{" +
            "name='" + name + '\'' +
            ", path='" + path + '\'' +
            ", isFile=" + isFile +
            '}';
  }
}
