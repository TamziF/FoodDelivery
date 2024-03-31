package com.example.fooddelivery.ui.view.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.fooddelivery.App
import com.example.fooddelivery.databinding.FragmentMenuBinding
import com.example.fooddelivery.ioc.menu_fragment.MenuFragmentComponent
import com.example.fooddelivery.ioc.menu_fragment.MenuFragmentViewComponent
import com.example.fooddelivery.ui.stateholders.MenuViewModel

class MenuFragment : Fragment() {

    /*private val list = listOf<Dish>(
        Dish(
            1,
            "123",
            "Ветчина и грибы",
            "Ветчина,шампиньоны, увеличинная порция моцареллы, томатный соус"
        ),
        Dish(
            2,
            "123",
            "Баварские колбаски",
            "Ветчина,шампиньоны, увеличинная порция моцареллы, томатный соус"
        ),
        Dish(
            3,
            "123",
            "Нежный лосось",
            "Лосось, томаты, оливки,соус песто,помидорки черри"
        ),
        Dish(
            4,
            "123",
            "Ветчина и грибы",
            "Ветчина,шампиньоны, увеличинная порция моцареллы, томатный соус"
        ),
        Dish(
            4,
            "123",
            "Ветчина и грибы",
            "Ветчина,шампиньоны, увеличинная порция моцареллы, томатный соус"
        ),
        Dish(
            4,
            "123",
            "Ветчина и грибы",
            "Ветчина,шампиньоны, увеличинная порция моцареллы, томатный соус"
        )
    )*/

    private lateinit var binding: FragmentMenuBinding

    private val applicationComponent
        get() = App.get(requireContext()).applicationComponent

    private lateinit var fragmentComponent: MenuFragmentComponent
    private var fragmentViewComponent: MenuFragmentViewComponent? = null

    private val viewModel: MenuViewModel by viewModels { applicationComponent.viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fragmentComponent = MenuFragmentComponent(
            viewModel = viewModel,
            fragment = this
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMenuBinding.inflate(inflater, container, false)

        fragmentViewComponent = MenuFragmentViewComponent(
            binding = binding,
            fragmentComponent = fragmentComponent
        ).apply {
            viewController.bindViews()
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentViewComponent?.viewController?.cleanReferences()
        fragmentViewComponent = null
    }
}