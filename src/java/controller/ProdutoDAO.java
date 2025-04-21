/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Banco;
import java.sql.ResultSet;

/**
 *
 * @author aluno
 */
public class ProdutoDAO {

        public ResultSet listar(int coddep) throws Exception {
        Banco bb;

        try {
            bb = new Banco();
            bb.comando = Banco.conexao.prepareStatement("Select codigo, descricao, preco, qtde, imagem, coddep  from produto  where coddep=? order by 2");
            bb.comando.setInt(1, coddep); 
            bb.tabela = bb.comando.executeQuery();
            Banco.conexao.close();
            return (bb.tabela);
        } catch (Exception ex) {
            throw new Exception("Erro ao consultar o banco: " + ex.getMessage());
        }

    }
}
