package business.DTO;

public class UniversitarioDTO {

    private String fullName;
    private String code;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "UniversitarioDTO{" +
                "fullName='" + fullName + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
