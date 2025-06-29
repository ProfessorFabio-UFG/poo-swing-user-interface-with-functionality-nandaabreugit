import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FichaAvaliacao extends JFrame {
    public FichaAvaliacao() {
        super("Ficha de Avaliação");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menuArquivo = new JMenu("Arquivo");
        JMenu menuEnviar = new JMenu("Enviar");
        JMenuItem itemEmail = new JMenuItem("email");
        JMenuItem itemImpressora = new JMenuItem("impressora");
        JMenuItem itemSalvar = new JMenuItem("Salvar");
        JMenuItem itemSair = new JMenuItem("Sair");
        JMenu menuEditar = new JMenu("Editar");

        //ações dos menus
        itemEmail.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Opção 'email' selecionada.");
                JOptionPane.showMessageDialog(null, "Simulação de envio por email.");
            }
        });

        itemImpressora.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Opção 'impressora' selecionada.");
                JOptionPane.showMessageDialog(null, "Simulação de envio para impressora.");
            }
        });

        itemSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Opção 'Salvar' selecionada.");
                JOptionPane.showMessageDialog(null, "Simulação de salvamento de dados.");
            }
        });

        itemSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Opção 'Sair' selecionada.");
                int confirm = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "Confirmação", JOptionPane.YES_NO_OPTION);
                if(confirm == JOptionPane.YES_OPTION) {
                    dispose();
                }
            }
        });

        menuEnviar.add(itemEmail);
        menuEnviar.add(itemImpressora);
        menuArquivo.add(menuEnviar);
        menuArquivo.add(itemSalvar);
        menuArquivo.add(itemSair);
        menuBar.add(menuArquivo);
        menuBar.add(menuEditar);
        setJMenuBar(menuBar);

        //titulo
        JLabel titulo = new JLabel("Ficha de Avaliação", JLabel.CENTER);
        titulo.setForeground(Color.RED);
        add(titulo, BorderLayout.NORTH);

        //painel central
        JPanel painelCentro = new JPanel(new BorderLayout());

        //dados pessoais
        JPanel painelDados = new JPanel(new GridLayout(3, 2, 5, 5));
        painelDados.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        painelDados.add(new JLabel("Código :"));
        painelDados.add(new JTextField(10));
        painelDados.add(new JLabel("Nome :"));
        painelDados.add(new JTextField(20));
        painelDados.add(new JLabel("Sexo :"));

        JRadioButton feminino = new JRadioButton("Feminino");
        JRadioButton masculino = new JRadioButton("Masculino");
        ButtonGroup grupoSexo = new ButtonGroup();
        grupoSexo.add(feminino);
        grupoSexo.add(masculino);

        JPanel painelSexo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        painelSexo.add(feminino);
        painelSexo.add(masculino);
        painelDados.add(painelSexo);

        painelCentro.add(painelDados, BorderLayout.NORTH);

        //curriculo
        JPanel painelCV = new JPanel(new BorderLayout());
        painelCV.setBorder(BorderFactory.createTitledBorder("Curriculum Vitae"));
        JTextArea txtCV = new JTextArea(6, 40);
        JScrollPane scrollCV = new JScrollPane(txtCV);
        painelCV.add(scrollCV, BorderLayout.CENTER);

        painelCentro.add(painelCV, BorderLayout.CENTER);

        //painel areas
        JPanel painelAreas = new JPanel(new GridLayout(2, 2, 10, 5));
        painelAreas.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.LIGHT_GRAY),
                "Áreas", 0, 0, null, Color.BLUE));

        JLabel lblInteresse = new JLabel("Interesse :");
        JLabel lblAtuacao = new JLabel("Atuação :");

        String[] opcoesInteresse = {"Desenvolvedor", "Analista", "Tester"};
        String[] opcoesAtuacao = {"Programação", "Documentação", "Gerência"};

        JComboBox<String> comboInteresse = new JComboBox<>(opcoesInteresse);
        JScrollPane spInteresse = new JScrollPane(comboInteresse);

        JComboBox<String> comboAtuacao = new JComboBox<>(opcoesAtuacao);
        JScrollPane spAtuacao = new JScrollPane(comboAtuacao);

        painelAreas.add(lblInteresse);
        painelAreas.add(lblAtuacao);
        painelAreas.add(spInteresse);
        painelAreas.add(spAtuacao);

        painelCentro.add(painelAreas, BorderLayout.SOUTH);

        add(painelCentro, BorderLayout.CENTER);

        //botoes
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        painelBotoes.setBackground(Color.GREEN);

        String[] textosBotoes = {"Salvar", "Anterior", "Proximo", "Novo", "Cancelar"};
        int i = 0;
        while(i < textosBotoes.length) {
            String texto = textosBotoes[i];
            JButton botao = new JButton(texto);
            botao.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Botão '" + texto + "' pressionado.");
                    if(texto.equals("Cancelar")) {
                        int confirm = JOptionPane.showConfirmDialog(null, "Deseja realmente cancelar?", "Confirmação", JOptionPane.YES_NO_OPTION);
                        if(confirm == JOptionPane.YES_OPTION) {
                            System.out.println("Ação cancelada pelo usuário.");
                        }
                    }
                }
            });
            painelBotoes.add(botao);
            i++;
        }

        add(painelBotoes, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        FichaAvaliacao t = new FichaAvaliacao();
    }
}
