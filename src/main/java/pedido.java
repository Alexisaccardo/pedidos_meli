public class pedido {

    public String code;
    public String name;
    public String name_product;
    public String document;
    public String state;

    public pedido(String code, String name, String name_product, String document, String state) {
        this.code = code;
        this.name = name;
        this.name_product = name_product;
        this.document = document;
        this.state = state;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName_product() {
        return name_product;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
