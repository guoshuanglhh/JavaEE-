package com.zhiyou.servletleasecontract;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou.pojo.LeaseContract;
import com.zhiyou.service.LeaseContractService;
import com.zhiyou.service.impl.LeaseContractServiceImpl;

@WebServlet(description = "添加合同", urlPatterns = { "/user/addLeaseContractInformationServlet" })
public class AddLeaseContractInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LeaseContractService contractService = new LeaseContractServiceImpl();
		LeaseContract contract = new LeaseContract();
		contract.setLc_contract_number(request.getParameter("lc_contract_number"));
		contract.setH_id(Integer.parseInt(request.getParameter("h_id")));
		contract.setL_id(Integer.parseInt(request.getParameter("l_id")));
		contract.setLc_contract_date(request.getParameter("lc_contract_date"));
		contract.setLc_contract_start_date(request.getParameter("lc_contract_start_date"));
		contract.setLc_contract_end_date(request.getParameter("lc_contract_end_date"));
		contract.setLc_total_rent(Double.parseDouble(request.getParameter("lc_total_rent")));
		contract.setLc_pay_way(Integer.parseInt(request.getParameter("lc_pay_way")));
		contract.setLc_deposit(Double.parseDouble(request.getParameter("lc_deposit")));
		contract.setLc_period_payment(Integer.parseInt(request.getParameter("lc_period_payment")));
		contract.setLc_contract_signer(request.getParameter("lc_contract_signer"));
		contract.setLc_contract_state(request.getParameter("lc_contract_state"));
		String message = contractService.addLeaseContractInformationService(contract);
		if("租赁合同添加成功".equals(message)){
			response.sendRedirect("queryRectInformationByConditionServlet");
		}else{
			response.sendRedirect("addLeaseContract.jsp");
		}
	}
}
