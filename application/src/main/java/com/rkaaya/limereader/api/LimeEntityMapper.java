package com.rkaaya.limereader.api;

import com.rkaaya.lime.domain.model.Lime;
import com.rkaaya.limereader.services.dao.entity.LimeEntity;

public interface LimeEntityMapper {

    Lime mapEntityToLime(LimeEntity limeEntity);
    LimeEntity mapLimeToEntity(Lime lime, Long created);
}
