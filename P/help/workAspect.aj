package p;

public aspect workAspect {

        after() : execution(* work(..))
        {
		System.out.println("my work after ASPECT");
	}
}
