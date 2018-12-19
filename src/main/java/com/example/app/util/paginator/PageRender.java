package com.example.app.util.paginator;

import org.springframework.data.domain.Page;

public class PageRender<T> {
	
	private String url;
	private Page<T> page;
	int desde;
	int hasta;
	
	private int totalPaginas;
	private int numElementosPorPagina;
	private int paginaActual;
	
	public PageRender(String url, Page<T> page) {
		super();
		this.url = url;
		this.page = page;
		
		numElementosPorPagina = page.getSize();
		totalPaginas = page.getTotalPages();
		paginaActual = page.getNumber() + 1;
		
		
		if(totalPaginas  <= numElementosPorPagina ) {
			desde = 1;
			hasta = totalPaginas;
		}else {
			if(paginaActual <= numElementosPorPagina /2 ) {
				desde  = 1;
				hasta = totalPaginas;
			}else if( paginaActual >= totalPaginas - numElementosPorPagina /2  )  {
				desde = totalPaginas - numElementosPorPagina +1;
				hasta = numElementosPorPagina;
			}else {
				desde = paginaActual - numElementosPorPagina / 2 ;
				hasta = numElementosPorPagina; 
			}
			
		}
	}
		
	
}
