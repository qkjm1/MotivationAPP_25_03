package org.example.motivation.entity;

class Motivation { //조립 틀
    private int id;
    private String body;
    private String source;

    public Motivation(int id, String body, String source) {
        this.id = id;
        this.body = body;
        this.source = source;
    }


    public int getId() {
        return id;
    }
    public String getSource() {
        return source;
    }
    public String getBody() {
        return body;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public void setBody(String body) {
        this.body = body;
    }
}
