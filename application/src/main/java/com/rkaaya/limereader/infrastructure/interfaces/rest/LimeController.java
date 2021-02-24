package com.rkaaya.limereader.infrastructure.interfaces.rest;

import com.rkaaya.lime.domain.model.Lime;
import com.rkaaya.lime.reader_server.api.BetvictorApi;
import com.rkaaya.limereader.api.LimeReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LimeController implements BetvictorApi {

    @Autowired
    private LimeReaderService limeReaderService;

    @Override
    public ResponseEntity<List<Lime>> limeHistory() {
        return ResponseEntity.ok(limeReaderService.getLastTenComputate());
    }
}
