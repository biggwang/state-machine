package com.biggwang.state.enity;

import com.biggwang.state.code.StatesEnum;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserStateEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, nullable = false)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private StatesEnum state;
}
