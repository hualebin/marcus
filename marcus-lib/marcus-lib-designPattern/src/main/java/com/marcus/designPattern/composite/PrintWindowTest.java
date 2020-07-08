package com.marcus.designPattern.composite;

public class PrintWindowTest {

    public static void main(String[] args) {
        // 创建窗口、组件，并组装
        WinForm winForm = new WinForm("WINDOW窗口");
        Picture picture = new Picture("LOGO图片");
        Button loginButton = new Button("登录按钮");
        Button registerButton = new Button("注册按钮");
        Frame frame = new Frame("FRAME1");
        Label accountLabel = new Label("用户名");
        TextBox accountTextBox = new TextBox("文本框");
        Label passwordLabel = new Label("密码");
        PasswordBox passwordBox = new PasswordBox("密码框");
        CheckBox checkBox = new CheckBox("复选框");
        TextBox rememberAccountTextBox = new TextBox("记住用户名");
        LinkLabel linkLabel = new LinkLabel("忘记密码");
        frame.addComponent(accountLabel);
        frame.addComponent(accountTextBox);
        frame.addComponent(passwordLabel);
        frame.addComponent(passwordBox);
        frame.addComponent(checkBox);
        frame.addComponent(rememberAccountTextBox);
        frame.addComponent(linkLabel);

        winForm.addComponent(picture);
        winForm.addComponent(loginButton);
        winForm.addComponent(registerButton);
        winForm.addComponent(frame);

        // 打印窗口
        winForm.print();
    }
}
