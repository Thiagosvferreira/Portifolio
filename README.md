# 🎰 CassinoTH — Jogo de Apostas "Crash"

Simulação de um jogo estilo **Crash**, comum em plataformas de apostas online. O jogador aposta um valor e acompanha um multiplicador que cresce até "crashar" em um momento aleatório. O objetivo é retirar o dinheiro antes da explosão.

Projeto focado no aprendizado prático de **Java**, **Programação Orientada a Objetos (POO)** e **lógica de jogos com estímulos visuais e sonoros**.

---

## 🚀 Funcionalidades

- Simulação de aposta com valor e multiplicador
- Explosão aleatória com base em tempo e probabilidade
- Efeitos sonoros (isqueiro, explosão) para maior imersão
- Emojis e delays para reforçar feedbacks visuais
- Estrutura modular (application, model, utils, web)
- Refatoração constante com foco em boas práticas de POO

---

## 🧠 Conceitos aplicados

- Programação Orientada a Objetos (POO)
- Controle de fluxo e manipulação de tempo (Thread.sleep)
- Uso de bibliotecas externas (ex: Gson para serialização)
- Organização de projeto em camadas: `model`, `application`, `utils`, `web`

---

## 🛠️ Tecnologias

- Java 21
- JavaFX (interface gráfica em desenvolvimento)
- Gson (para salvar histórico e simular base de dados)
- IDE: VS Code

---

## 📁 Estrutura do projeto

/src
├── application/
│ └── JogoCrash.java
├── model/
│ └── Aposta.java
├── utils/
│ └── CrashSimulator.java
├── web/
│ ├── TelaInicial.java
│ └── TelaJogo.java
└── Main.java
/lib
└── gson-2.10.1.jar
