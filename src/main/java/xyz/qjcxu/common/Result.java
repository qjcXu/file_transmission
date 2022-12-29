package xyz.qjcxu.common;

/**
 * @since 22.12.28 20:23
 */
public class Result {
  private boolean success;

  private int code;

  private String msg;

  private Object data;

  public Result() {}

  public Result(boolean success) {
    this.success = success;
  }

  public static Result success() {
    return new Result(true);
  }

  public static Result error() {
    return new Result(false);
  }

  public Result setCodeMsg(int code, String msg) {
    this.code = code;
    this.msg = msg;
    return this;
  }

  public Result setData(Object data) {
    this.data = data;
    return this;
  }

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public Object getData() {
    return data;
  }
}
