package com.github.isaquesb.happy_java_api.domain.orphanages.create_steps;

import com.github.isaquesb.happy_java_api.domain.orphanages.Orphanage;
import org.springframework.web.multipart.MultipartFile;

public record CreateRequest(Orphanage orphanage, MultipartFile[] files) {
}
