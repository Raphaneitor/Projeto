/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import BancoDAO.ProdutoDAO;
import java.util.ArrayList;
import Model.Produto;

/**
 *
 * @author raphael.ldalmeida
 */
public class ProdutoController {
    
    public static boolean salvar(String pNomeProduto, String pModeloProduto,int pQuantidadeProduto, String pMarcaProduto, String pCategoriaProduto, String pGeneroProduto, int pTamanhoProduto, double pPrecoProduto, String pDescricaoProduto)
    {
        //Salvo na memória
        Produto p =  new Produto(pNomeProduto,pModeloProduto,pQuantidadeProduto,pMarcaProduto,pCategoriaProduto,pGeneroProduto,pTamanhoProduto,pPrecoProduto,pDescricaoProduto);
        return ProdutoDAO.salvarProduto(p);
    }
    
    public static boolean excluir(int pIDProduto)
    {
        return ProdutoDAO.excluirProduto(pIDProduto);
    }
    
    public static boolean atualizar(int pIdProduto,String pNomeProduto, String pModeloProduto,int pQuantidadeProduto, String pMarcaProduto, String pCategoriaProduto, String pGeneroProduto, int pTamanhoProduto, double pPrecoProduto, String pDescricaoProduto)
    {
        Produto p =  new Produto(pIdProduto,pNomeProduto,pModeloProduto,pQuantidadeProduto,pMarcaProduto,pCategoriaProduto,pGeneroProduto,pTamanhoProduto,pPrecoProduto,pDescricaoProduto);
        return ProdutoDAO.atualizarProduto(p);
        
    }
    
    public static ArrayList<String[]> getProdutos()
    {
        ArrayList<Produto> produtos = ProdutoDAO.getProdutos();
        ArrayList<String[]> listaProdutos = new ArrayList<>();
        
        for(int i=0;i<produtos.size();i++)
        {
            listaProdutos.add(new String[]{String.valueOf(produtos.get(i).getIdProduto()),produtos.get(i).getNomeProduto(),produtos.get(i).getModeloProduto() ,String.valueOf(produtos.get(i).getQuantidadeProduto()),produtos.get(i).getMarcaProduto(),produtos.get(i).getCategoriaProduto(),produtos.get(i).getGeneroProduto(),String.valueOf(produtos.get(i).getTamanhoProduto()),String.valueOf(produtos.get(i).getPrecoProduto()),produtos.get(i).getDescricaoProduto() });
        
        }
        
        return listaProdutos;
        
    }
    
}
