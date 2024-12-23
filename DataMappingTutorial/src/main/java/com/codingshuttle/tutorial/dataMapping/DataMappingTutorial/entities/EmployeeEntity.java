package com.codingshuttle.tutorial.dataMapping.DataMappingTutorial.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "employees")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToOne(mappedBy = "manager")
    @JsonIgnore
    private DepartmentEntity managedDepartment;

    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "worker_department_id")
    @JoinTable(name = "worker_department_mapping")
    @JsonIgnore
    private DepartmentEntity workerDepartment;

    @ManyToMany
    @JoinTable(name = "freelancer_department_mapping",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "department_id")
    )
    @JsonIgnore
    private Set<DepartmentEntity> freelanceDepartments;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeEntity that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(updatable = false)
    private LocalDateTime updateDate;

    @CreatedBy
    private String createdBy;

    @LastModifiedBy
    private String updatedBy;
}
