package com.rkaaya.limereader.services.dao.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class LimeEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "frequent_word", nullable = false)
    private String freqWord;

    @Column(name = "average_paragraph_size", nullable = false)
    private Integer avgParagraphSize;

    @Column(name = "average_paragraph_processing_time", nullable = false)
    private Long avgParagraphProcessingTime;

    @Column(name = "total_processing_time", nullable = false)
    private Long totalProcessingTime;

    @Column(name = "message_created", nullable = false)
    private Long messageCreated;

    @CreatedDate
    @Column(name = "created_date")
    private Date createdDate;
}
