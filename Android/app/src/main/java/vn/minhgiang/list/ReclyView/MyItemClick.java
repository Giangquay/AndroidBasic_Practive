package vn.minhgiang.list.ReclyView;
// ham ho tro khi nguoi dung click chuot vao recycleView
public interface MyItemClick<T> {
    void OnclickItemListener(T t);
//    void OnLongclickItemListener(T t);
}
