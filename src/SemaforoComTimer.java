import javax.swing.*;
import  java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SemaforoComTimer extends JFrame {

    private JLabel semaforoLabel;

    private Timer timer;
    private int estadoAtual = 0; // 0: Verde, 1:Amarelo, 2:Vermelho


    public SemaforoComTimer(){
        setTitle("Semaforo com Timer");
        setSize(200,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        semaforoLabel = new JLabel();
        semaforoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        semaforoLabel.setFont(new Font("Arial",Font.BOLD,24));
        add(semaforoLabel,BorderLayout.CENTER);

        timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (estadoAtual) {
                    case 0:
                        setEstadoAmarelo();
                        break;
                    case 1:
                        setEstadoVermelho();
                        break;
                    case 2:
                        setEstadoVerde();
                        break;

                }
            }
        });
        timer.start();
        setEstadoVerde();
    }

    private void setEstadoVerde(){
        semaforoLabel.setText("Verde");
        semaforoLabel.setForeground(Color.GREEN);
        estadoAtual=0;
    }
    private void setEstadoAmarelo(){
        semaforoLabel.setText("Amarelo");
        semaforoLabel.setForeground(Color.YELLOW);
        estadoAtual=1;
    }
    private void setEstadoVermelho(){
        semaforoLabel.setText("Vermelho");
        semaforoLabel.setForeground(Color.RED);
        estadoAtual=2;
    }

}
