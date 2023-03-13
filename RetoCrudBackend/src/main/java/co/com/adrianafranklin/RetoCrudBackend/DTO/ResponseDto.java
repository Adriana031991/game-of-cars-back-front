package co.com.adrianafranklin.RetoCrudBackend.DTO;


/*
responde los datos
 */

import co.com.adrianafranklin.RetoCrudBackend.Entitys.Player;

public class ResponseDto {

    private Object data;
    private String mensaje;


    public ResponseDto(Object data, String mensaje) {
        this.data = data;
        this.mensaje= mensaje;
    }

    public ResponseDto(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


}
