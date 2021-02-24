package com.rkaaya.limereader.api;

import com.rkaaya.lime.domain.model.Lime;

import java.util.List;

public interface LimeReaderService {

    List<Lime> getLastTenComputate();
    void saveLimeMessage(Lime lime, Long createdTime);
}
