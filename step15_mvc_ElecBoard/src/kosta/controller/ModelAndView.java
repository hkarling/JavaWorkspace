package kosta.controller;

/**
 * 클라이언트에 응답전에 이동할 url 주소와 이동방식을 관리하는 클래스
 */
public class ModelAndView {
    private String path; // 최종 뷰 페이지
    private boolean isRedirect; // true:redirect, false:forward

    public ModelAndView() {
    }

    public ModelAndView(String path) {
        this.path = path;
    }

    public ModelAndView(String path, boolean isRedirect) {
        this(path);
        this.isRedirect = isRedirect;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isRedirect() {
        return isRedirect;
    }

    public void setRedirect(boolean redirect) {
        isRedirect = redirect;
    }
}
