package applciation;

public class Singleton {
  private static volatile Singleton instance;
  private String data;

  private   Singleton(String data) {
    this.data = data;
  }

  public static Singleton getInstance(String data) {
    Singleton result = instance ;
    if (result == null) {
      synchronized (Singleton.class) {
        if (instance == null) {
          instance = new Singleton(data);
        }
      }
    }
    return instance;
  }
}
