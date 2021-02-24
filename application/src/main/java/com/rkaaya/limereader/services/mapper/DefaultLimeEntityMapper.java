package com.rkaaya.limereader.services.mapper;

import com.rkaaya.lime.domain.model.Lime;
import com.rkaaya.limereader.api.LimeEntityMapper;
import com.rkaaya.limereader.services.dao.entity.LimeEntity;

public class DefaultLimeEntityMapper implements LimeEntityMapper {

    @Override
    public Lime mapEntityToLime(final LimeEntity limeEntity) {
        return Lime.builder()
                .freqWord(limeEntity.getFreqWord())
                .totalProcessingTime(limeEntity.getTotalProcessingTime())
                .avgParagraphSize(limeEntity.getAvgParagraphSize())
                .avgParagraphProcessingTime(limeEntity.getAvgParagraphProcessingTime())
                .build();
    }

    @Override
    public LimeEntity mapLimeToEntity(final Lime lime, final Long created) {
        return LimeEntity.builder()
                .avgParagraphProcessingTime(lime.getAvgParagraphProcessingTime())
                .avgParagraphSize(lime.getAvgParagraphSize())
                .freqWord(lime.getFreqWord())
                .totalProcessingTime(lime.getTotalProcessingTime())
                .messageCreated(created)
                .build();
    }
}
