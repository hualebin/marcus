package org.marcus.lib.annotaion;

public @interface Uniqueness {
	Constraints constraints() default @Constraints(unique = true);
}
