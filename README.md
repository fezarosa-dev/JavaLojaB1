# Projeto: Loja Virtual

### 👨‍🏫 Disciplina
Linguagem e Técnica de Programação II  
Prof. Dr. Prampero

### 👥 Colaboradores
- Felipe

---

## 🧾 Descrição
Site de compras baseado em uma loja com:
- 3 departamentos
- 6 produtos por departamento
- Carrinho de compras
- Login de usuário
- Finalização de compra com registro no banco de dados

### 🎯 Funcionalidades principais
- Interface dividida em 3 iframes:
  - Esquerdo: departamentos
  - Direito: produtos do departamento
  - Superior: logo, botão de login e carrinho
- Produtos possuem imagem, descrição, preço, quantidade
- Carrinho com total por item e total geral
- Verifica login antes de finalizar compra

---

## ⚙️ Tecnologias Utilizadas
- Java (MVC)
- HTML / CSS (com pelo menos 5 tags personalizadas)
- Node.js (geração dos dados de departamentos e produtos)
- PostgreSQL (banco de dados)

---

## 💾 Banco de Dados (PostgreSQL)
Banco: `loja`

### Tabelas principais:
```sql
create table cliente (
  codigo serial primary key,
  nome varchar(100),
  login varchar(100) unique,
  senha char(32)
);

create table departamento(
  codigo serial primary key,
  nome varchar(50)
);

create table produto (
  codigo serial primary key,
  descricao varchar(100),
  preco float,
  qtde int check(qtde >=0),
  imagem varchar(100),
  coddep int not null references departamento(codigo) on update cascade
);

create table venda(
  codigo serial primary key,
  total float default 0,
  datav timestamp default current_timestamp,
  codcli int not null references cliente(codigo) on update cascade
);

create table item (
  codigo serial primary key,
  qtde int check(qtde>0),
  precounit float,
  codproduto int not null references produto(codigo) on update cascade,
  codvenda int not null references venda(codigo) on update cascade
);
```

---

## 📁 Estrutura de Pastas
```
/controller
  - Controlador.java
  - DepartamentoDAO.java
  - ProdutoDAO.java

/model
  - Banco.java
  - Departamento.java
  - Produto.java

/view
  - ListarDep.java
  - ListarProduto.java
```

---

## 🚀 Como Executar o Projeto
1. Importe o projeto Java em sua IDE (ex: NetBeans ou Eclipse)
2. Configure o banco de dados PostgreSQL com o script acima
3. Execute o servidor Node.js para gerar dados
4. Execute a aplicação Java
5. Acesse a interface HTML com os iframes
6. Clique em "comprar" para adicionar ao carrinho
7. Clique em "finalizar" e faça login para registrar a venda

---

## 🎨 Estilização (CSS)
- Pelo menos 5 tags estilizadas estão presentes no CSS aplicado a todas as páginas
- Figuras de produtos: `fig1.jpg`, `fig2.jpg`, etc.

---

## 🔐 Login e Finalização
- O sistema verifica se o cliente está logado antes de finalizar a compra
- Caso não esteja, aparece mensagem e link para login/cadastro

---

## ✅ Conclusão
Projeto completo seguindo o padrão MVC, com funcionalidades de compra, banco de dados, estilização, login e integração entre Java, HTML/CSS e Node.js.

---
