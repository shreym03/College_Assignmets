(
	de a(start stop)
		(setq evensum 0)
		(setq oddsum 0)
		(let Val start
			(loop
				(if (=0 (% Val 2))
						(setq evensum (+ evensum Val))
						(setq oddsum (+ oddsum Val)))
				(inc 'Val)
				(T (=0 (% Val (+ stop 1)))) 
			)
		)
	(prinl "Odd sum:")
	(prinl oddsum)
	(prinl "Even sum:")
	(prinl evensum)
)
