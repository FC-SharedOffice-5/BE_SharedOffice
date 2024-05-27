package com.FC.SharedOfficePlatform.domain.business.entity;

import com.FC.SharedOfficePlatform.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "business")
@NoArgsConstructor
@Getter
public class Business extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "business_id", nullable = false)
    private Long businessId;

    @Column(name = "business_name", length = 50, nullable = false)
    private String businessName;

    @Column(name = "business_type", length = 6)
    private String businessType;

    @Column(name = "business_num")
    private int businessNum;

    @Column(name = "business_contract_start_date")
    private LocalDate businessContractStartDate;

    @Column(name = "business_contract_end_date")
    private LocalDate businessContractEndDate;

    @Column(name = "business_ceo", length = 25)
    private String businessCeo;

    @Column(name = "business_phone", length = 13)
    private String businessPhone;

    @Column(name = "business_contract_person", length = 25)
    private String businessContractPerson;

    @Column(name = "business_contract_phone", length = 13)
    private String businessContractPhone;


    @Builder
    public Business(
            String businessName,
            String businessType,
            int businessNum,
            LocalDate businessContractStartDate,
            LocalDate businessContractEndDate,
            String businessCeo,
            String businessPhone,
            String businessContractPerson,
            String businessContractPhone
    ) {
        this.businessName = businessName;
        this.businessType = businessType;
        this.businessNum = businessNum;
        this.businessContractStartDate = businessContractStartDate;
        this.businessContractEndDate = businessContractEndDate;
        this.businessCeo = businessCeo;
        this.businessPhone = businessPhone;
        this.businessContractPerson = businessContractPerson;
        this.businessContractPhone = businessContractPhone;
    }

}
