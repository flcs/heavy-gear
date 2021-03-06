package br.com.bcunha.heavygear.model.pojo;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.content.ContextCompat;

import br.com.bcunha.heavygear.R;

/**
 * Created by BRUNO on 18/09/2016.
 */
public class Ativo implements Parcelable {
    private String codigo;
    private String empresa;
    private String tipo;
    private double cotacao;
    private double variacao;
    private double abertura;
    private double maximaDia;
    private double minimaDia;
    private double maximaAno;
    private double minimaAno;
    private double cotaocaoDolar;
    private int volumeNegociacao;
    private boolean inWatch;
    private boolean isViewExpanded = false;
    private int originalHeight;
    private int index;
    private boolean refresh;

    public Ativo(String codigo){
        this.codigo = codigo;
    }

    public Ativo(String codigo, String empresa, String tipo, double cotacao) {
        this.codigo = codigo;
        this.empresa = empresa;
        this.tipo = tipo;
        this.cotacao = cotacao;
    }

    public Ativo(String codigo, String empresa, String tipo, double cotacao, boolean inWatch) {
        this.codigo = codigo;
        this.empresa = empresa;
        this.tipo = tipo;
        this.cotacao = cotacao;
        this.inWatch = inWatch;
    }

    public Ativo(String codigo, String empresa, String tipo, double cotacao, double variacao, boolean inWatch) {
        this.codigo = codigo;
        this.empresa = empresa;
        this.tipo = tipo;
        this.cotacao = cotacao;
        this.variacao = variacao;
        this.inWatch = inWatch;
    }

    public Ativo(String codigo, String empresa, String tipo, double cotacao, double variacao, double maximaDia, double minimaDia, double maximaAno, double minimaAno, int volumeNegociacao, boolean inWatch) {
        this.codigo = codigo;
        this.empresa = empresa;
        this.tipo = tipo;
        this.cotacao = cotacao;
        this.variacao = variacao;
        this.maximaDia = maximaDia;
        this.minimaDia = minimaDia;
        this.maximaAno = maximaAno;
        this.minimaAno = minimaAno;
        this.volumeNegociacao = volumeNegociacao;
        this.inWatch = inWatch;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getTipo() {
        if(tipo == null) {
            return "";
        } else {
            return tipo;
        }
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getCotacao() {
        return cotacao;
    }

    public void setCotacao(double cotacao) {
        setRefresh(this.cotacao != cotacao ? true : false);
        this.cotacao = cotacao;
    }

    public double getVariacao() {
        return variacao;
    }

    public String getVariacaoFormat() {
        String sinal = "";
        if(getVariacao() > 0) {
            return "(+" + String.format("%.2f", getVariacao()) + ")";
        } else if(getVariacao() > 0) {
            return "(-" + String.format("%.2f", getVariacao() * 1) + ")";
        } else {
            return "(" + String.format("%.2f", getVariacao()) + ")";
        }
    }

    public void setVariacao(double variacao) {
        this.variacao = variacao;
    }

    public double getAbertura() { return abertura; }

    public void setAbertura(double abertura) { this.abertura = abertura; }

    public double getMaximaDia() {
        return maximaDia;
    }

    public void setMaximaDia(double maximaDia) {
        this.maximaDia = maximaDia;
    }

    public double getMinimaDia() {
        return minimaDia;
    }

    public void setMinimaDia(double minimaDia) {
        this.minimaDia = minimaDia;
    }

    public double getMaximaAno() {
        return maximaAno;
    }

    public void setMaximaAno(double maximaAno) {
        this.maximaAno = maximaAno;
    }

    public double getMinimaAno() {
        return minimaAno;
    }

    public void setMinimaAno(double minimaAno) {
        this.minimaAno = minimaAno;
    }

    public double getCotaocaoDolar() {
        return cotaocaoDolar;
    }

    public void setCotaocaoDolar(double cotaocaoDolar) {
        this.cotaocaoDolar = cotaocaoDolar;
    }

    public int getVolumeNegociacao() {
        return volumeNegociacao;
    }

    public void setVolumeNegociacao(int volumeNegociacao) {
        this.volumeNegociacao = volumeNegociacao;
    }

    public boolean isInWatch() {
        return inWatch;
    }

    public void setInWatch(boolean inWatch) {
        this.inWatch = inWatch;
    }

    public boolean isViewExpanded() {
        return isViewExpanded;
    }

    public void setViewExpanded(boolean viewExpanded) {
        isViewExpanded = viewExpanded;
    }

    public int getOriginalHeight() {
        return originalHeight;
    }

    public void setOriginalHeight(int originalHeight) {
        this.originalHeight = originalHeight;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean isRefresh() {
        return refresh;
    }

    public void setRefresh(boolean refresh) {
        this.refresh = refresh;
    }

    public int getImgId(Context context) {
        int imgId = context.getResources().getIdentifier(getCodigo().replaceAll("\\d", "").toLowerCase(),
                                                         "drawable",
                                                         context.getPackageName());
        if(imgId == 0){
            imgId = context.getResources().getIdentifier("logo_indisponivel",
                                                         "drawable",
                                                         context.getPackageName());
        }
        return imgId;
    }

    public ColorStateList getCor(Context context){
        if (!getTipo().equals("MOEDA")) {
            if (getVariacao() > 0) {
                return ColorStateList.valueOf(ContextCompat.getColor(context, R.color.verde));
            } else if (getVariacao() < 0) {
                return ColorStateList.valueOf(ContextCompat.getColor(context, R.color.vermelho));
            } else {
                return ColorStateList.valueOf(ContextCompat.getColor(context, R.color.textoSecundario));
            }
        } else {
            return ColorStateList.valueOf(ContextCompat.getColor(context, R.color.preto));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ativo ativo = (Ativo) o;

        return codigo.equals(ativo.codigo);

    }

    @Override
    public int hashCode() {
        return codigo.hashCode();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(codigo);
        parcel.writeString(empresa);
        parcel.writeString(tipo);
        parcel.writeDouble(cotacao);
        parcel.writeDouble(cotaocaoDolar);
        parcel.writeDouble(variacao);
        parcel.writeDouble(maximaDia);
        parcel.writeDouble(minimaDia);
        parcel.writeDouble(maximaAno);
        parcel.writeDouble(minimaAno);
        parcel.writeInt(volumeNegociacao);
        parcel.writeInt(inWatch ? 1 : 0);
        parcel.writeInt(isViewExpanded ? 1 : 0);
        parcel.writeInt(originalHeight);
        parcel.writeInt(index);
        parcel.writeInt(refresh ? 1 : 0);
    }

    // Creator
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Ativo createFromParcel(Parcel in) {
            return new Ativo(in);
        }

        public Ativo[] newArray(int size) {
            return new Ativo[size];
        }
    };

    // Objeto
    public Ativo(Parcel in) {
        this.codigo = in.readString();
        this.empresa = in.readString();
        this.tipo = in.readString();
        this.cotacao = in.readDouble();
        this.cotaocaoDolar = in.readDouble();
        this.variacao = in.readDouble();
        this.maximaDia = in.readDouble();
        this.minimaDia = in.readDouble();
        this.maximaAno = in.readDouble();
        this.minimaAno = in.readDouble();
        this.volumeNegociacao = in.readInt();
        this.inWatch = (in.readInt() == 0) ? false : true;
        this.isViewExpanded = (in.readInt() == 0) ? false : true;
        this.originalHeight = in.readInt();
        this.index = in.readInt();
        this.refresh = (in.readInt() == 0) ? false : true;
    }
}