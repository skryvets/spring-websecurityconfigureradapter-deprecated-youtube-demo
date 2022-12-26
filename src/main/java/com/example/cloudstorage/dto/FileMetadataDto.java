package com.example.cloudstorage.dto;

import com.example.cloudstorage.enums.FileFormat;
import com.example.cloudstorage.enums.FileType;
import com.example.cloudstorage.enums.Language;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileMetadataDto {
    private String title;
    private String creator;
    private List<String> contributors;
    private String description;
    private String publisher;
    private String subject;
    private Long identifier;
    private Language language;
    private String rights;
    private FileType type;
    private FileFormat format;
    private String source;
    //TODO add "created" and "modified" for the video, maybe "size" if not enough timing to film the video
    private String created;
    private String modified;
}
