## Happy API - Java Version

This is the Java version of the [Happy API](https://github.com/isaquesb/happy-api) project.

### DIO Design Patterns Challenge

Original Repository: [Design Patterns with Spring](https://github.com/digitalinnovationone/lab-padroes-projeto-spring)

Applied pattern list:

- Chain of Responsibility (for create orphanage)
- Factory Method (for create orphanage and images resources)
- Abstract Factory (for create image)

### Class Diagrams

```mermaid
classDiagram
    class Image {
        private String uuid;
        private String path;
        private String downloadUrl;
        private String disk;
        private String metadata;
        private Orphanage orphanage;
    }

    class Orphanage {
        private String uuid;
        private String name;
        private String about;
        private String instructions;
        private String openingHours;
        private Boolean openOnWeekends;
        private Address address;
        private Coordinates coordinates;
        private List<Image> images;
    }
    
    class Address {
        private String street;
        private String number;
        private String neighborhood;
        private String city;
        private String state;
        private String country;
        private String zipCode;
    }
    
    class Coordinates {
        private String latitude;
        private String longitude;
    }
    
    Orphanage --> Image
    Orphanage --> Address
    Orphanage --> Coordinates
```
