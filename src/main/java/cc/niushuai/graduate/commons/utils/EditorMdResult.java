package cc.niushuai.graduate.commons.utils;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 结合editor.md 使用的结果类
 *
 * @author niushuai
 */
@Slf4j
@Data
public class EditorMdResult {

    /**
     * 0表示上传成功 1表示上传失败
     */
    private int success;
    /**
     * 提示信息
     */
    private String message;
    /**
     * 图片地址
     */
    private String url;

    private static EditorMdResult editorMdResult;

    public EditorMdResult code(int code) {
        editorMdResult.setSuccess(code);
        return editorMdResult;
    }

    public EditorMdResult msg(String msg) {
        editorMdResult.setMessage(msg);
        return editorMdResult;
    }

    public EditorMdResult url(String url) {
        editorMdResult.url = url;
        return editorMdResult;
    }

    /**
     * 上传成功
     *
     * @param url
     * @return
     */
    public static EditorMdResult ok(String url) {
        return ok(url, "上传成功");
    }

    /**
     * 上传成功
     *
     * @param url
     * @param msg
     * @return
     */
    public static EditorMdResult ok(String url, String msg) {
        reset();
        return editorMdResult.code(1).msg(msg).url(url);
    }

    /**
     * 上传失败
     *
     * @param msg
     * @return
     */
    public static EditorMdResult error(String msg) {
        reset();
        return editorMdResult.code(0).msg(msg).url("");
    }

    /**
     * 防止上次的状态还在, 在下次使用时重置该对象
     */
    private static void reset() {
        editorMdResult = new EditorMdResult();
    }
}
