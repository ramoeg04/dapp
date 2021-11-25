package com.dapp.util;

import javax.faces.flow.SwitchCase;
import javax.websocket.Endpoint;

import org.springframework.stereotype.Service;

import com.dapp.entities.endpoint1.Endpoint1;
import com.dapp.entities.endpoint1.Endpoint1data;
import com.dapp.entities.endpoint2.Endpoint2;
import com.dapp.entities.endpoint2.Endpoint2data;
import com.dapp.entities.endpoint3.Endpoint3;
import com.dapp.entities.endpoint3.Endpoint3data;
import com.dapp.entities.endpoint3.Endpoint3payments;
import com.dapp.entities.endpoint4.Endpoint4;
import com.dapp.entities.endpoint4.Endpoint4data;
import com.dapp.entities.endpoint5.Endpoint5;
import com.dapp.entities.endpoint5.Endpoint5data;

@Service
public class handler {

// Leyenda
//	data = 0 -> ok 
//	data = 1->	Objeto del Endpoint Vacio 
//	data = 2->	 Datos del Objeto del Endpoint Vacio  
//	data = 3->	Endpoint Fallo 

	public int handler1(Endpoint1 Endpoint1) {
		int data = 0;
		if (Endpoint1 != null) {
			if (Endpoint1.getRc() == 0) {
				for (Endpoint1data i : Endpoint1.getData()) {
					if (i.getId() == null) {
						data = 2;
						break;
					} else if (i.getQr() == null) {
						data = 2;
						break;
					}
				}
			} else {
				return data = 3;
			}
		} else {
			return data = 1;
		}
		return data;
	}

	public int handler2(Endpoint2 Endpoint2) {
		int data = 0;
		if (Endpoint2 != null) {
			if (Endpoint2.getRc() == 0) {
				if (Endpoint2.getData().getId().isEmpty()) {
					return data = 2;
				} else {
					if (Endpoint2.getData().getQr_image().isEmpty()) {
						return data = 2;
					} else {
						if (Endpoint2.getData().getAmount().isEmpty()) {
							return data = 2;
						} else {
							if (Endpoint2.getData().getDescription().isEmpty()) {
								return data = 2;
							}
						}
					}
				}
			} else {
				return data = 3;
			}
		} else {
			return data = 1;
		}
		return data;
	}

	public int handler3(Endpoint3 Endpoint3) {
		int data = 0;
		if (Endpoint3 != null) {
			if (Endpoint3.getRc() == 0) {
				if (Endpoint3.getData().getId().isEmpty()) {
					return data = 2;
				} else {
					if (Endpoint3.getData().getPayments().isEmpty()) {
						return data = 2;
					} else {
						for (Endpoint3payments i : Endpoint3.getData().getPayments()) {
							if (i.getId() == null) {
								data = 2;
								break;
							}
						}
					}
				}
			} else {
				return data = 3;
			}
		} else {
			return data = 1;
		}
		return data;
	}

	public int handler4(Endpoint4 Endpoint4) {
		int data = 0;
		if (Endpoint4 != null) {
			if (Endpoint4.getRc() == 0) {
				if (Endpoint4.getData().getId() == null) {
					return data = 2;
				}
			} else {
				return data = 3;
			}
		} else {
			return data = 1;
		}
		return data;
	}

	public int handler5(Endpoint5 Endpoint5) {
		int data = 0;
		if (Endpoint5 != null) {
			if (Endpoint5.getRc() == 0) {
				if (Endpoint5.getData().getId() == null) {
					return data = 2;
				} else {
					if (Endpoint5.getData().getAmount() == null) {
						return data = 2;
					}
				}

			} else {
				return data = 3;
			}
		} else {
			return data = 1;
		}
		return data;
	}
}
