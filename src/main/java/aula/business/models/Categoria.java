package aula.business.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cat_id;

    @NotNull
    private int cat_num;

    @NotBlank
    private String cat_color;

    @NotBlank
    @Size(max = 25)
    private String cat_name;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    private List<Documento> documentos;

    public Categoria() {
    }

    public Categoria(int cat_num, String cat_color, String cat_name) {
        this.cat_num = cat_num;
        this.cat_color = cat_color;
        this.cat_name = cat_name;
    }

    public Long getCat_id() {
        return cat_id;
    }

    public void setCat_id(Long cat_id) {
        this.cat_id = cat_id;
    }

    public int getCat_num() {
        return cat_num;
    }

    public void setCat_num(int cat_num) {
        this.cat_num = cat_num;
    }

    public String getCat_color() {
        return cat_color;
    }

    public void setCat_color(String cat_color) {
        this.cat_color = cat_color;
    }

    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }
}