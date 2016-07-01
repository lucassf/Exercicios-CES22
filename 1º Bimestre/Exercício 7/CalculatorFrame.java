package ces22;

public class CalculatorFrame extends javax.swing.JFrame {

    // Os botões foram dividos em quatro classes distintas: dígitos, operação,
    // resultado e limpar. Botões pertencentes a mesma classe executam de modo
    // basicamente igual.
    private enum CurrentAction {
        DIGIT, OPERATION, RESULT, CLEAR;
    };
    private final Calculator calculator;
    private final InputHandler inputhandler;
    private CurrentAction currentaction;

    public CalculatorFrame() {
        initComponents();
        calculator = new Calculator();
        inputhandler = new InputHandler();
        currentaction = CurrentAction.CLEAR;
    }

    // Método chamado caso pressionado um dígito ou o botão Del
    private void DigitPressed(char digit) {
        if (currentaction == CurrentAction.RESULT) {
            calculator.clear();
        }
        if (currentaction != CurrentAction.DIGIT) {
            inputhandler.ResetInput();
            if (digit=='u')calculator.clear();
        }
        inputhandler.setInput(digit);
        currentaction = CurrentAction.DIGIT;
        Field.setText(inputhandler.getInput());
    }

    // Método chamado quando pressiona-se +/-
    private void SignalPressed(Calculator.Operation operation) {
        String answer;
        try {
            if (currentaction == CurrentAction.DIGIT) {
                calculator.changeNum(Double.parseDouble(inputhandler.getInput()));
            }
            answer = calculator.getAns();
        } catch (IllegalArgumentException e) {
            answer = e.getMessage();
            calculator.clear();
        }
        calculator.changeOperation(operation);
        Field.setText(answer);
        currentaction = CurrentAction.OPERATION;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        Button8 = new javax.swing.JButton();
        Button5 = new javax.swing.JButton();
        Button2 = new javax.swing.JButton();
        Field = new javax.swing.JTextField();
        Button0 = new javax.swing.JButton();
        TimesButton = new javax.swing.JButton();
        DivisionButton = new javax.swing.JButton();
        PlusButton = new javax.swing.JButton();
        MinusButton = new javax.swing.JButton();
        Button1 = new javax.swing.JButton();
        ClearButton = new javax.swing.JButton();
        Button7 = new javax.swing.JButton();
        Button4 = new javax.swing.JButton();
        Button3 = new javax.swing.JButton();
        EqualsButton = new javax.swing.JButton();
        Button9 = new javax.swing.JButton();
        Button6 = new javax.swing.JButton();
        DotButton = new javax.swing.JButton();
        UndoButton = new javax.swing.JButton();
        PlusMinusButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ver. 0.5");
        setResizable(false);

        Button8.setText("8");
        Button8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button8ActionPerformed(evt);
            }
        });

        Button5.setText("5");
        Button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button5ActionPerformed(evt);
            }
        });

        Button2.setText("2");
        Button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button2ActionPerformed(evt);
            }
        });

        Field.setEditable(false);
        Field.setText("0");

        Button0.setText("0");
        Button0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button0ActionPerformed(evt);
            }
        });

        TimesButton.setText("x");
        TimesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimesButtonActionPerformed(evt);
            }
        });

        DivisionButton.setText("/");
        DivisionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DivisionButtonActionPerformed(evt);
            }
        });

        PlusButton.setText("+");
        PlusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlusButtonActionPerformed(evt);
            }
        });

        MinusButton.setText("-");
        MinusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MinusButtonActionPerformed(evt);
            }
        });

        Button1.setText("1");
        Button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button1ActionPerformed(evt);
            }
        });

        ClearButton.setText("C");
        ClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearButtonActionPerformed(evt);
            }
        });

        Button7.setText("7");
        Button7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button7ActionPerformed(evt);
            }
        });

        Button4.setText("4");
        Button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button4ActionPerformed(evt);
            }
        });

        Button3.setText("3");
        Button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button3ActionPerformed(evt);
            }
        });

        EqualsButton.setText("=");
        EqualsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EqualsButtonActionPerformed(evt);
            }
        });

        Button9.setText("9");
        Button9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button9ActionPerformed(evt);
            }
        });

        Button6.setText("6");
        Button6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button6ActionPerformed(evt);
            }
        });

        DotButton.setText(".");
        DotButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DotButtonActionPerformed(evt);
            }
        });

        UndoButton.setText("Del");
        UndoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UndoButtonActionPerformed(evt);
            }
        });

        PlusMinusButton.setText("+/-");
        PlusMinusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlusMinusButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Field, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Button4, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                                    .addComponent(Button7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Button5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Button8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(7, 7, 7))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(UndoButton)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Button1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(Button2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(PlusButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Button9, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Button6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(Button3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(11, 11, 11)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(DivisionButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(MinusButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TimesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Button0, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PlusMinusButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DotButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(EqualsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(UndoButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Button7)
                            .addComponent(Button8)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Button4)
                                        .addComponent(Button5))
                                    .addComponent(Button6)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PlusButton)
                            .addComponent(ClearButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(TimesButton))
                            .addComponent(Button9)
                            .addComponent(MinusButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DivisionButton)
                            .addComponent(Button3)
                            .addComponent(Button2)
                            .addComponent(Button1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EqualsButton)
                    .addComponent(DotButton)
                    .addComponent(PlusMinusButton)
                    .addComponent(Button0))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void Button0ActionPerformed(java.awt.event.ActionEvent evt) {                                        
        DigitPressed('0');
    }                                       

    private void Button1ActionPerformed(java.awt.event.ActionEvent evt) {                                        
        DigitPressed('1');
    }                                       

    private void Button2ActionPerformed(java.awt.event.ActionEvent evt) {                                        
        DigitPressed('2');
    }                                       

    private void Button3ActionPerformed(java.awt.event.ActionEvent evt) {                                        
        DigitPressed('3');
    }                                       

    private void Button4ActionPerformed(java.awt.event.ActionEvent evt) {                                        
        DigitPressed('4');
    }                                       

    private void Button5ActionPerformed(java.awt.event.ActionEvent evt) {                                        
        DigitPressed('5');
    }                                       

    private void Button6ActionPerformed(java.awt.event.ActionEvent evt) {                                        
        DigitPressed('6');
    }                                       

    private void Button7ActionPerformed(java.awt.event.ActionEvent evt) {                                        
        DigitPressed('7');
    }                                       

    private void Button8ActionPerformed(java.awt.event.ActionEvent evt) {                                        
        DigitPressed('8');
    }                                       

    private void Button9ActionPerformed(java.awt.event.ActionEvent evt) {                                        
        DigitPressed('9');
    }                                       

    private void PlusButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        SignalPressed(Calculator.Operation.ADD);
    }                                          

    private void MinusButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        SignalPressed(Calculator.Operation.SUBTRACT);
    }                                           

    private void TimesButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        SignalPressed(Calculator.Operation.MULTIPLY);
    }                                           

    private void DivisionButtonActionPerformed(java.awt.event.ActionEvent evt) {                                               
        SignalPressed(Calculator.Operation.DIVIDE);
    }                                              

    private void EqualsButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        SignalPressed(Calculator.Operation.RESULT);
        currentaction = CurrentAction.RESULT;
    }                                            

    private void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        calculator.clear();
        inputhandler.ResetInput();
        Field.setText("0");
        currentaction = CurrentAction.CLEAR;
    }                                           

    private void DotButtonActionPerformed(java.awt.event.ActionEvent evt) {                                          
        DigitPressed('.');
    }                                         

    private void UndoButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        DigitPressed('u');
    }                                          

    private void PlusMinusButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                
        DigitPressed('-');
    }                                               

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CalculatorFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton Button0;
    private javax.swing.JButton Button1;
    private javax.swing.JButton Button2;
    private javax.swing.JButton Button3;
    private javax.swing.JButton Button4;
    private javax.swing.JButton Button5;
    private javax.swing.JButton Button6;
    private javax.swing.JButton Button7;
    private javax.swing.JButton Button8;
    private javax.swing.JButton Button9;
    private javax.swing.JButton ClearButton;
    private javax.swing.JButton DivisionButton;
    private javax.swing.JButton DotButton;
    private javax.swing.JButton EqualsButton;
    private javax.swing.JTextField Field;
    private javax.swing.JButton MinusButton;
    private javax.swing.JButton PlusButton;
    private javax.swing.JButton PlusMinusButton;
    private javax.swing.JButton TimesButton;
    private javax.swing.JButton UndoButton;
    // End of variables declaration                   
}
