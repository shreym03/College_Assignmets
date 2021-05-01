//Gate-level description of a 2-to-4-line decoder
module decoder_gl (A,B,E,D);
	input A,B,E;
	output [0:3]D;
	wire Anot,Bnot,Enot;
	not
		n1 (Anot,A),
		n2 (Bnot,B),
		n3 (Enot,E);
	nand
		n4 (D[0],Anot,Bnot,Enot),
		n5 (D[1],Anot,B,Enot),
		n6 (D[2],A,Bnot,Enot),
		n7 (D[3],A,B,Enot);
endmodule

module testdecoder;
	reg A,B,E;
	wire Anot,Bnot,Enot;	
	wire [0:3]D;
	decoder_gl d (A,B,E,D);
	initial
		  begin
			E = 1'b1; 
			#10 E = 1'b0; A = 1'b0; B = 1'b0;
			#10 E = 1'b0; A = 1'b0; B = 1'b1;
			#10 E = 1'b0; A = 1'b1; B = 1'b0;
			#10 E = 1'b0; A = 1'b1; B = 1'b1;
		  end
initial
#100 $finish; 
endmodule   
