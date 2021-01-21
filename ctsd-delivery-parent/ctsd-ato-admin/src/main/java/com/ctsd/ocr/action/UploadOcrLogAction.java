package com.ctsd.ocr.action;

import com.ctsd.frame.entity.dto.ReturnDto;
import com.ctsd.ocr.domain.vo.OcrLogParaVo;
import com.ctsd.ocr.service.UploadOcrLogService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 项目名称:  com.ctsd.intelligent.ocr.action
 * 类名称:  UploadOcrLogAction
 * 描述:上传图片识别log
 * @author humanxing
 * 创建时间:  2020/9/28 17:18
 * 修改人: humanxing  修改日期: 2020/9/28 17:18
 * 修改备注:
 */
@RestController
@RequestMapping("/ocr")
public class UploadOcrLogAction {

    @Resource
    UploadOcrLogService uploadOcrLogService;


    /**
     * 上传图片识别log
     * @param ocrLogParaDo
     * @return
     */
    @ApiOperation(value = "上传图片识别log")
    @PostMapping("/uploadOcrLog")
    public ReturnDto<String> uploadOcrLog(OcrLogParaVo ocrLogParaDo){
        return uploadOcrLogService.uploadOcrLog(ocrLogParaDo);
    }

}