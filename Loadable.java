public interface Loadable<T> {
    void load(T t);
    T unload();
}
