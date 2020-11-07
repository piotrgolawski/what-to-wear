package com.pgitp.whattowear.drools.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.compress.utils.Lists;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Equipment {
    List<String> toTake = Lists.newArrayList();

    public void take(String toTake) {
        if(!this.toTake.contains(toTake)) {
            this.toTake.add(toTake);
        }

    }

    public String getToTakeString() {
        return String.join(", ", this.toTake);
    }
}
