package com.zzr.base.controller;

import com.zzr.base.api.R;
import com.zzr.base.utils.Charsets;
import com.zzr.base.utils.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourceRegion;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.UriUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * BaseController
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2022/12/28 10:21
 */
@Controller
public class BaseController {

    @Autowired
    private HttpServletRequest request;

//    public AppUser getUser() {
//        return AuthUtil.getUser();
//    }

    public <T> R<T> data(T data) {
        return R.data(data);
    }

    public <T> R<T> data(T data, String message) {
        return R.data(data, message);
    }

    public <T> R<T> data(T data, String message, int code) {
        return R.data(code, data, message);
    }

    public R success(String message) {
        return R.success(message);
    }

    public R fail(String message) {
        return R.fail(message);
    }

    public R status(boolean flag) {
        return R.status(flag);
    }

    protected ResponseEntity<ResourceRegion> download(File file) throws IOException {
        String fileName = file.getName();
        return this.download(file, fileName);
    }

    protected ResponseEntity<ResourceRegion> download(File file, String fileName) throws IOException {
        Resource resource = new FileSystemResource(file);
        return this.download((Resource) resource, fileName);
    }

    protected ResponseEntity<ResourceRegion> download(Resource resource, String fileName) throws IOException {
        HttpServletRequest request = WebUtil.getRequest();
        String header = request.getHeader("User-Agent");
        header = header == null ? "" : header.toUpperCase();
        String msie = "MSIE";
        String trident = "TRIDENT";
        String edge = "EDGE";
        HttpStatus status;
        if (!header.contains(msie) && !header.contains(trident) && !header.contains(edge)) {
            status = HttpStatus.CREATED;
        } else {
            status = HttpStatus.OK;
        }

        long position = 0L;
        long count = resource.contentLength();
        String range = request.getHeader("Range");
        if (null != range) {
            status = HttpStatus.PARTIAL_CONTENT;
            String[] rangeRange = range.replace("bytes=", "").split("-");
            position = Long.parseLong(rangeRange[0]);
            if (rangeRange.length > 1) {
                long end = Long.parseLong(rangeRange[1]);
                count = end - position + 1L;
            }
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        String encodeFileName = UriUtils.encode(fileName, Charsets.UTF_8);
        String disposition = "attachment;filename=\"" + encodeFileName + "\";filename*=utf-8''" + encodeFileName;
        headers.set("Content-Disposition", disposition);
        return new ResponseEntity(new ResourceRegion(resource, position, count), headers, status);
    }
}
