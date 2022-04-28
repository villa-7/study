package com.roger.bytebuddy.agent;

import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.agent.builder.ResettableClassFileTransformer;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.utility.JavaModule;

import java.lang.instrument.Instrumentation;

import static net.bytebuddy.matcher.ElementMatchers.*;

public class AgentDemo {

    private static Instrumentation instrumentation;
    private static ResettableClassFileTransformer fileTransformer;

    static {
        try {
            instrumentation = ByteBuddyAgent.getInstrumentation();
        } catch (Exception e) {
            instrumentation = ByteBuddyAgent.install(new ByteBuddyAgent.AttachmentProvider.Compound(
                    ByteBuddyAgent.AttachmentProvider.DEFAULT
            ));
        }
    }

    public static void install() {
        if (instrumentation == null) {
            return;
        }
        fileTransformer = new AgentBuilder.Default()
                .type(named("com.roger.bytebuddy.agent.bean.User"))
                .transform(new AgentBuilder.Transformer() {
                    @Override
                    public DynamicType.Builder<?> transform(DynamicType.Builder<?> builder,
                                                            TypeDescription typeDescription,
                                                            ClassLoader classLoader, JavaModule module) {
                        return builder.method(named("sayHello")).intercept(FixedValue.value("helloTransform"));
                    }
                }).installOn(instrumentation);
    }

    public static void unInstall() {
        if (fileTransformer != null) {
            fileTransformer.reset(instrumentation, AgentBuilder.RedefinitionStrategy.REDEFINITION,
                    AgentBuilder.RedefinitionStrategy.BatchAllocator.ForFixedSize.ofSize(1));
        }
    }
}
