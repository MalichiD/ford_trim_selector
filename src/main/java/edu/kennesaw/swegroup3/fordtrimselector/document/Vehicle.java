package edu.kennesaw.swegroup3.fordtrimselector.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document("vehicle")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {

    @Id
    private String id;

    private String model;
    private String year;

    private List<Trim> trims;
    private List<String> images;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Trim {
        @Id
        private String id;
        private String name;
        private Integer starting_msrp;

        private Engine engine;
        private Battery battery;
        private Drivetrain drivetrain;
        @Field("fuel_efficiency")
        private FuelEfficiency fuelEfficiency;
        private MPGe mpge;
        private Body body;
        @Field("pickup_bed")
        private PickupBed pickupBed;

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Engine {
            private String type;
            private String engine_model;
            private Integer horsepower;
            private Integer torque;
            private String fuel_type;
            private Double fuel_capacity;
        }

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Drivetrain {
            private String transmission;
            private String drive_type;
        }

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Battery {
            private String port_type;
            private Integer capacity;
            private Integer range;
            private Double charge_time;
            private Integer kwh_per_100_miles;
        }

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        public static class FuelEfficiency {
            private Integer city;
            private Integer highway;
            private Integer combined;
        }

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        public static class MPGe {
            private Integer city;
            private Integer highway;
            private Integer combined;
        }

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Body {
            private String body_type;
            private Integer doors;
            private Integer seats;
            private Double length;
            private Double width;
            private Double height;
            private Double wheelbase;
            private Integer towing_capacity;
            private Integer cargo_capacity_max;
            private Integer cargo_capacity_seats_in_place;
            private Integer curb_weight;
        }

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        public static class PickupBed {
            private Double length;
            private Integer payload_capacity;
        }
    }
}