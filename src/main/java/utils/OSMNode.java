package utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OSMNode {
    private Long id;
    private double latitude;
    private double longitude;
    private Map<String, String> tags;
}
